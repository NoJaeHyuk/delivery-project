package com.sjc.delivery.domain.store.service;

import com.sjc.delivery.domain.store.dto.request.StoreRegisterRequest;
import com.sjc.delivery.domain.store.dto.request.StoreUpdateRequest;
import com.sjc.delivery.domain.store.entity.Store;
import java.util.List;

public interface StoreService {

    Store registerStore(Long user_id, StoreRegisterRequest storeRegisterRequest);

    Store updateStore(StoreUpdateRequest storeUpdateRequest);

    List<Store> findAllStore();

    Store findById(Long storeId);

}

