package com.manish.walletapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)

public class WalletExecption extends RuntimeException   {

    public WalletExecption(String message )
    {
        super(message);
    }
}
