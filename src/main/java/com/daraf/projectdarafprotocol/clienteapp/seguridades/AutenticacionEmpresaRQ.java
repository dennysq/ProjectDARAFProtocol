/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daraf.projectdarafprotocol.clienteapp.seguridades;

import com.daraf.projectdarafprotocol.Cuerpo;
import com.daraf.projectdarafprotocol.model.Empresa;
import com.daraf.projectdarafutil.MyStringUtil;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Alejandra Ponce
 */
public class AutenticacionEmpresaRQ implements Cuerpo {

    private String userId;
    private String password;

    @Override
    public String asTexto() {
        return this.userId + password;
    }

    @Override
    public boolean validate(String input) {
        return input.length() == 40;
    }

    @Override
    public void build(String input) {
        if (validate(input)) {
            try {

                String values[] = MyStringUtil.splitByFixedLengths(input, new int[]{20, 20});
                this.userId = values[0];
                this.password = values[1];

            } catch (Exception e) {
                System.out.println("" + e);
            }
        }

    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = StringUtils.rightPad(userId, 20, " ");
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = StringUtils.rightPad(password, 20, " ");
    }

}
