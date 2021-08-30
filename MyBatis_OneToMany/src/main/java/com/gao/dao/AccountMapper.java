package com.gao.dao;

import com.gao.domain.Account;
import com.gao.domain.AccountUser;

import java.util.List;

/**
 * @author gaols
 * @version 1.0
 * @date 2021/8/22 18:22
 */
public interface AccountMapper {

    List<Account> findAll();
}
