package ru.akbirov.transferservice.service;

import ru.akbirov.transferservice.model.TransferRestModel;

public interface TransferService {
    public boolean transfer(TransferRestModel productPaymentRestModel);
}
