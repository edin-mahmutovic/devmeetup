package com.devmeetuptuzla.demo.account.service.mapper;

import com.devmeetuptuzla.demo.account.entity.Account;
import com.devmeetuptuzla.demo.account.service.dto.AccountCreateDTO;
import com.devmeetuptuzla.demo.account.service.dto.AccountDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface AccountMapper {

    @Mapping(target = "id", ignore = true)
    Account toEntity(AccountCreateDTO accountCreateDTO);

    @Mapping(target = "transactions", ignore = true)
    AccountDTO toDTO(Account account);
}
