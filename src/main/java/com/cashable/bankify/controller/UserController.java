package com.cashable.bankify.controller;

import com.cashable.bankify.dto.impl.UserRequestDTO;
import com.cashable.bankify.dto.impl.UserIdDTO;
import com.cashable.bankify.dto.impl.UserResponseDTO;
import com.cashable.bankify.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @Operation(summary = "Obtém usuário pelo ID")
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUser(@PathVariable("id") String id){

        UserResponseDTO userDb = userService.findById(id);

        return ResponseEntity.ok(userDb);
    }

    @Operation(summary = "Cria novo usuário")
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Usuário criado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Erro ao criar usuário"),
        @ApiResponse(responseCode = "409", description = "Usuário já existe"),
        @ApiResponse(responseCode = "500", description = "Erro interno")
    })
    @PostMapping()
    public ResponseEntity<UserIdDTO> createUser(@RequestBody UserRequestDTO user, UriComponentsBuilder uriComponentsBuilder){

        UserIdDTO userId = userService.create(user.toModel());

        URI uri = uriComponentsBuilder
                                .path("/users/{id}")
                                .buildAndExpand(userId)
                                .toUri();

        return ResponseEntity.created(uri).body(userId);
    }
}
