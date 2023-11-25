package com.sjc.delivery.domain.store.service;

import com.sjc.delivery.domain.store.dto.request.StoreRegisterRequest;
import com.sjc.delivery.domain.store.dto.request.StoreUpdateRequest;
import com.sjc.delivery.domain.store.entity.Store;
import com.sjc.delivery.domain.store.exception.NoSuchStore;
import com.sjc.delivery.domain.store.repository.StoreRepository;
import com.sjc.delivery.domain.user.entity.User;
import com.sjc.delivery.domain.user.repository.UserRepository;
import com.sjc.delivery.global.enums.ErrorCode;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public Store registerStore(Long user_id, StoreRegisterRequest storeRegisterRequest) {
        User user = userRepository.findById(user_id)
            .orElseThrow(() -> new RuntimeException("유저 정보를 찾을 수 없습니다."));
        return storeRepository.save(storeRegisterRequest.toEntity(user));
    }

    @Override
    @Transactional
    public Store updateStore(StoreUpdateRequest storeUpdateRequest) {
        Store curStore = storeRepository.findById(storeUpdateRequest.getStore_id())
            .orElseThrow(() -> new NoSuchStore(
                ErrorCode.STORE_NOT_FOUND));

        curStore.updateStore(storeUpdateRequest.getStoreName(),
            storeUpdateRequest.getFoodCategory(), storeUpdateRequest.getAddress()
            , storeUpdateRequest.getPhone(), storeUpdateRequest.getDescription(),
            storeUpdateRequest.getStoreImage(), storeUpdateRequest.getMinDeliveryPrice());

        return curStore;
    }

    @Override
    public List<Store> findAllStore() {
        return storeRepository.findAll();
    }

    @Override
    public Store findById(Long storeId) {
        return storeRepository.findById(storeId)
            .orElseThrow(() -> new NoSuchStore(ErrorCode.STORE_NOT_FOUND));
    }
}
