package com.fbn.lcm.decisionengine;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fbn.lcm.deploymentengine.DeploymentEngine;
import com.fbn.lcm.deploymentrules.DeploymentRules;
import com.fbn.lcm.scalingpolicy.ScalingPolicies;

@Component
public class DecisionEngine{
	@Autowired
	ScalingPolicies scalingPolicies;
	
	@Autowired
	DeploymentEngine deploymentEngine;
	
	@Autowired
	DeploymentRules deploymentRules;
	
	public boolean execute(String serviceId, Map metrics){
		if(scalingPolicies.getPolicy(serviceId).execute(serviceId, metrics)){		
			return deploymentEngine.scaleUp(deploymentRules.getDeploymentRules(serviceId), serviceId);	
		}
		return false;
	}
}