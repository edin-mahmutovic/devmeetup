package com.devmeetuptuzla.demo.account.service.mapper;

import com.devmeetuptuzla.demo.account.entity.Account;
import com.devmeetuptuzla.demo.account.service.dto.AccountCreateDTO;
import org.mapstruct.Mapper;

@Mapper
public interface AccountMapper {

    Account toEntity(AccountCreateDTO accountCreateDTO);
}
