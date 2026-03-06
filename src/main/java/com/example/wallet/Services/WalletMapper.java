package com.example.wallet.Services;

import com.example.wallet.Dtos.WalletDTO;
import com.example.wallet.Models.Wallet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface WalletMapper {

    @Mapping(source = "user.id", target = "userId")
    WalletDTO toDto(Wallet wallet);

    @Mapping(source = "user.id", target = "userId")
    WalletDTO toEntity(WalletDTO walletDto);

    List<WalletDTO> toDtoList(List<Wallet> wallets);
    List<Wallet> toEntityList(List<WalletDTO> walletDtos);
}
