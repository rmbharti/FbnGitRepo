package com.fbn.auth.fb.service;

import com.fbn.auth.fb.model.Role;

/**
 * Created by christospapidas on 25012016--.
 */
public interface RoleService {

    Role findById(Long id);

    Role findByCode(String code);

}
