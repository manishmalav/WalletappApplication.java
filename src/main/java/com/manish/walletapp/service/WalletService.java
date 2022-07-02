package com.manish.walletapp.service;

import com.manish.walletapp.entity.Wallet;
import com.manish.walletapp.exception.WalletExecption;
import com.manish.walletapp.repository.WalletRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class WalletService {

    @Autowired
    private WalletRepository walletRepository;
    public List<Wallet> getAll()
    {
        return walletRepository.findAllByOrderByPriority();
    }

    public Wallet getById(Long id)
    {
        Optional<Wallet> wallet = walletRepository.findById(id);
        if(wallet.isPresent())
        {
            return wallet.get();
        }

        throw new WalletExecption("Wallet with "+ id +" does not exist!");
    }

    public Wallet createOrUpdate(@NotNull Wallet wallet)
    {
        if (wallet.getId() == null)
        {
           walletRepository.save(wallet);
        } else {
            walletRepository.save(wallet);
        }

        return wallet;
    }

    public boolean delete(Long id)
    {
        Optional<Wallet> wallet = walletRepository.findById(id);
        if(wallet.isPresent())
        {
            walletRepository.delete(wallet.get());
            return true;
        }

        throw new WalletExecption("Wallet with "+ id +" does not exist!");
    }
}
