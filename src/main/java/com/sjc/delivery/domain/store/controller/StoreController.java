package com.sjc.delivery.domain.store.controller;

import com.sjc.delivery.domain.store.dto.request.StoreRegisterRequest;
import com.sjc.delivery.domain.store.dto.request.StoreUpdateRequest;
import com.sjc.delivery.domain.store.dto.response.StoreResponse;
import com.sjc.delivery.domain.store.entity.Store;
import com.sjc.delivery.domain.store.service.StoreService;
import com.sjc.delivery.global.utils.ApiResponseUtils;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/store")
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService;

    @PostMapping("")
    public ResponseEntity<?> registerStore(@RequestBody StoreRegisterRequest storeRegisterRequest) {
        // 유저 ID, 로그인에 대한 부분이 정해지면 구현
        Long user_id = 1L;

        return ResponseEntity.ok(ApiResponseUtils.success("OK",
            StoreResponse.toResponse(storeService.registerStore(user_id, storeRegisterRequest))));
    }

    @PutMapping("")
    public ResponseEntity<?> updateStore(@RequestBody StoreUpdateRequest storeUpdateRequest) {
        return ResponseEntity.ok(ApiResponseUtils.success("OK",
            StoreResponse.toResponse(storeService.updateStore(storeUpdateRequest))));
    }

    @GetMapping("")
    public ResponseEntity<?> getAllStore() {
        List<Store> stores = storeService.findAllStore();

        List<StoreResponse> storeResponses = stores.stream()
            .map(m -> StoreResponse.toResponse(m))
            .collect(Collectors.toList());

        return ResponseEntity.ok(ApiResponseUtils.success("OK", storeResponses));
    }

    @GetMapping("/{storeId}")
    public ResponseEntity<?> getStore(@PathVariable Long storeId) {
        return ResponseEntity.ok(ApiResponseUtils.success("OK",
            StoreResponse.toResponse(storeService.findById(storeId))));
    }
}
