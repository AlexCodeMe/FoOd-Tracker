package com.alexcasey.food_tracker.service;

import java.util.Collections;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alexcasey.food_tracker.enums.RoleEnum;
import com.alexcasey.food_tracker.exception.AlreadyExistsException;
import com.alexcasey.food_tracker.model.Account;
import com.alexcasey.food_tracker.model.Role;
import com.alexcasey.food_tracker.repository.AccountRepository;
import com.alexcasey.food_tracker.repository.RoleRepository;
import com.alexcasey.food_tracker.request.AuthRequest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class AccountService {

    private final PasswordEncoder passwordEncoder;

    private final RoleRepository roleRepository;
    private final AccountRepository accountRepository;

    @Transactional
    public Account createAccount(AuthRequest request) {
        log.debug("Attempting to create account for username: {}", request.getUsername());

        Optional<Account> existingAccount = accountRepository.findByUsername(request.getUsername());
        if (existingAccount.isPresent()) {
            log.warn("Username already exists: {}", request.getUsername());
            throw new AlreadyExistsException("Username already exists");
        }

        Account newAccount = new Account();
        newAccount.setUsername(request.getUsername());
        newAccount.setPassword(passwordEncoder.encode(request.getPassword()));

        // Wallet wallet = walletService.createWallet();
        // newAccount.setWallet(wallet);
        // wallet.setAccount(newAccount);

        // Inventory inventory = inventoryService.createInventory();
        // newAccount.setInventory(inventory);
        // inventory.setAccount(newAccount);

        Role userRole = roleRepository.findByRole(RoleEnum.USER);
        newAccount.setRoles(Collections.singleton(userRole));

        Account savedAccount = accountRepository.save(newAccount);
        log.info("Successfully created account for username: {}", savedAccount.getUsername());
        return savedAccount;
    }
}
