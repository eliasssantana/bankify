package com.cashable.bankify.controller;

import com.cashable.bankify.dto.impl.UserRequestDTO;
import com.cashable.bankify.dto.IResponse;
import com.cashable.bankify.dto.Response;
import com.cashable.bankify.dto.impl.UserIdDTO;
import com.cashable.bankify.dto.impl.UserResponseDTO;
import com.cashable.bankify.exceptions.UserNotFoundException;
import com.cashable.bankify.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @Operation(summary = "Obtém todos os usuários cadastrados.")
    @ApiResponses(
            @ApiResponse(responseCode = "200", description = "Sucesso")
    )
    @GetMapping()
    public ResponseEntity<List<UserResponseDTO>> getUsers(){

        List<UserResponseDTO> users = userService.findAll();

        return ResponseEntity.ok(users);
    }

    @Operation(summary = "Obtém usuário pelo ID.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Sucesso"),
        @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUser(@PathVariable("id") String id){

        UserResponseDTO userDb = userService.findById(id);

        return ResponseEntity.ok(userDb);
    }

    @Operation(summary = "Cria novo usuário.")
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

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza usuário existente.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Usuário atualizado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Erro ao atualizar usuário"),
        @ApiResponse(responseCode = "404", description = "Usuário não encontrado"),
        @ApiResponse(responseCode = "500", description = "Erro interno")
    })
    public ResponseEntity<IResponse<UserResponseDTO>> updateUser(@PathVariable String id, @RequestBody UserRequestDTO userRequest){

        UserResponseDTO updatedUser = userService.update(id, userRequest.toModel());

        return ResponseEntity.ok(new Response<UserResponseDTO>(updatedUser));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Exclui usuário existente.")
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "Usuário excluído com sucesso"),
        @ApiResponse(responseCode = "404", description = "Usuário não encontrado"),
        @ApiResponse(responseCode = "500", description = "Erro interno")
    })
    public ResponseEntity<Void> deleteUserById(@PathVariable("id") String id){
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
