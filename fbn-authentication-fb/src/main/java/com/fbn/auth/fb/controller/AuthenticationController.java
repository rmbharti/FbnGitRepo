package com.fbn.auth.fb.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.autoconfigure.security.oauth2.resource.AuthoritiesExtractor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

	/*
	 * @RequestMapping("/user") public Principal user(Principal principal) {
	 * 
	 * 
	 * return principal; }
	 */

	@RequestMapping("/user")
	public Map<String, Object> user(Principal user) {
		Map<String, Object> map = new HashMap<String, Object>();
	
		// for a facebook the name is facebook id, not an actual name
		
		Authentication auth=(Authentication)user;
		
		Set<String> authorities=AuthorityUtils.authorityListToSet(auth.getAuthorities());
		
		map.put("name", user.getName());
		map.put("roles", authorities);
		
		
		//Downcast the Principal to an Authentication (or possibly OAuth2Authentication and grab the userAuthentication from that) and then look in the details property. If your user was authenticated using a UserInfoTokenServices you will see the Map returned from the external provider's user info endpoint.
	
		return map;
	}
	
	@Bean
	public AuthoritiesExtractor authoritiesExtractor(OAuth2RestOperations template) {
		return map -> {
			String url = (String) map.get("organizations_url");
			@SuppressWarnings("unchecked")
			List<Map<String, Object>> orgs = template.getForObject(url, List.class);
			if (orgs.stream().anyMatch(org -> "spring-projects".equals(org.get("login")))) {
				return AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");
			}
			throw new BadCredentialsException("Not in Spring Team");
		};
	}
	
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/user1")
	public Map<String, String> user1(Principal principal) {
	    if (principal != null) {
	        OAuth2Authentication oAuth2Authentication = (OAuth2Authentication) principal;
	        Authentication authentication = oAuth2Authentication.getUserAuthentication();
	        
	        Map<String, String> details = new LinkedHashMap<>();
	        
	        details = (Map<String, String>) authentication.getDetails();
	      
	           
	        Map<String, String> map = new LinkedHashMap<>();
	        map.put("email", details.get("email"));
	       
	        return map;
	    }
	    return null;
	}
}