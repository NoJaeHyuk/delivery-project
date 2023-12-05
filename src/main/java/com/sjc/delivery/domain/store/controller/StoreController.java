package com.sjc.delivery.domain.store.controller;

import com.sjc.delivery.domain.store.dto.request.StoreRegisterRequest;
import com.sjc.delivery.domain.store.dto.request.StoreUpdateRequest;
import com.sjc.delivery.domain.store.dto.response.StoreResponse;
import com.sjc.delivery.domain.store.entity.Store;
import com.sjc.delivery.domain.store.service.StoreService;
import com.sjc.delivery.global.resolver.Login;
import com.sjc.delivery.global.resolver.LoginInfo;
import com.sjc.delivery.global.response.ApiResponse;
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
@RequestMapping("api/stores")
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService;

    @PostMapping("")
    public ResponseEntity<?> registerStore(@RequestBody StoreRegisterRequest storeRegisterRequest,
        @Login LoginInfo loginInfo) {
        return ResponseEntity.ok(ApiResponseUtils.success(
            StoreResponse.from(storeService.registerStore(loginInfo.userId(), storeRegisterRequest))));
    }

    @PutMapping("")
    public ResponseEntity<?> updateStore(@RequestBody StoreUpdateRequest storeUpdateRequest) {
        return ResponseEntity.ok(ApiResponseUtils.success(
            StoreResponse.from(storeService.updateStore(storeUpdateRequest))));
    }

    @GetMapping("")
    public ResponseEntity<ApiResponse<List<StoreResponse>>> getAllStore() {
        List<Store> stores = storeService.findAllStore();

        List<StoreResponse> storeResponses = stores.stream()
            .map(m -> StoreResponse.from(m))
            .collect(Collectors.toList());

        return ResponseEntity.ok(ApiResponseUtils.success(storeResponses));
    }

    @GetMapping("/{storeId}")
    public ResponseEntity<?> getStore(@PathVariable Long storeId) {
        return ResponseEntity.ok(ApiResponseUtils.success(
            StoreResponse.from(storeService.findById(storeId))));
    }
}
