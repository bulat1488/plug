package com.example.plug.Controller;

import com.example.plug.Model.BalancesDTO.BalanceAccountInfoDTO;
import com.example.plug.Model.BalancesDTO.GetDepositBalancesResponseDTO;
import com.example.plug.Model.BalancesDTO.GetDepositsBalancesRequestDTO;
import com.example.plug.Model.BalancesDTO.InfoResponseGetDepositBalancesRsDTO;
import com.example.plug.Model.Permissions.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


// Заглушка на получение полномочий(прав) XML
@RestController
public class PermissionController {

    private Logger log = LoggerFactory.getLogger(PermissionController.class);

    ObjectMapper mapper = new ObjectMapper();

    // статистика по заглушке
    public int stat_in2 = 0, stat_out2 = 0, stat_err2 = 0, stat_curr2 = 0;//postPermissions
    public long start_time2 = 0L, sum_time2 = 0L;
    List<String[]> stat_tps2 = new ArrayList<>();

    @PostMapping(
            value = "/permissions",
            produces = MediaType.APPLICATION_XML_VALUE,
            consumes = MediaType.APPLICATION_XML_VALUE
    )
    public Object postPermissions(@RequestBody GetPermissionsRequest getPermissionsRequest) {
        stat_curr2++;    //входящие запросы заглушки
        start_time2 = System.currentTimeMillis();

        try {
            String ownerId = getPermissionsRequest.getOwnerID();

            System.out.println(ownerId);
            String epkId = ownerId.substring(0,19);

            char firstDigit = epkId.charAt(0);
            char thirdDigit = epkId.charAt(2);

            if (firstDigit == '3' && thirdDigit == '4') {
                epkId = epkId.substring(0,2) + '2' + epkId.substring(3);
            } else if (firstDigit == '3'  && thirdDigit == '5') {
                epkId = epkId.substring(0,2) + '4' + epkId.substring(3);
            } else {
                epkId = ownerId.substring(0,19);
            }

            String rqUID = getPermissionsRequest.getRqUID();

//            String documentType = "";
//            Random random = new Random();
//            int randomNum = random.nextInt(30);
//
//            if (randomNum <= 10) {
//                documentType = "1"; ----------------------- для примера рандомизации поля
//            } else if (randomNum <= 20) {
//                documentType = "2";
//            } else {
//                documentType = "3";
//            }

            ListPermissionDTO listPermissionDTO = new ListPermissionDTO();

            List<PermissionDTO> permission = new ArrayList<>();

            PermissionDTO permissionDTO = new PermissionDTO();

            PermissionTypeDTO permissionTypeDTO = new PermissionTypeDTO();

            permissionDTO.setPersonId(ownerId);
            permissionDTO.setRepresentId(epkId);
            permissionDTO.setDocumentId("01fsdgfab48564fshgd789");
            permissionDTO.setTypePerson("trustor");

            permission.add(permissionDTO);

            listPermissionDTO.setPermissionDTO(permission);

            permissionTypeDTO.setListPermission(listPermissionDTO);

            permissionTypeDTO.setListPermission(listPermissionDTO);

            GetPermissionsResponse getPermissionsResponse = new GetPermissionsResponse();

            getPermissionsResponse.setRqUID(rqUID);
            getPermissionsResponse.setRqTM(getPermissionsRequest.getRqTM());
            getPermissionsResponse.setPermission(permissionTypeDTO);


            log.error("******* GetDepositsBalancesRequestDTO *******" + mapper.writerWithDefaultPrettyPrinter().writeValueAsString(getPermissionsRequest));
            log.error("******* GetDepositBalancesResponseDTO *******" + mapper.writerWithDefaultPrettyPrinter().writeValueAsString(getPermissionsResponse));

//----------------------------------------------------------------------------

            long pacing = ThreadLocalRandom.current().nextLong(100, 600);
            long end_time = System.currentTimeMillis();
            if (end_time - start_time2 < pacing)   // задержска заглушки
                Thread.sleep( pacing - (end_time - start_time2));
//----------------------------------------------------------------------------

            stat_out2++; // исходящие ответы заглушки
            sum_time2 += System.currentTimeMillis() - start_time2;
            return getPermissionsResponse;//getPermissionsResponseDTO;
        } catch (Exception e) {
            stat_err2++;  // ошибки в заглушке
            sum_time2 += System.currentTimeMillis() - start_time2;
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
