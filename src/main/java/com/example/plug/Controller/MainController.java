package com.example.plug.Controller;

import com.example.plug.Model.BalancesDTO.BalanceAccountInfoDTO;
import com.example.plug.Model.BalancesDTO.GetDepositBalancesResponseDTO;
import com.example.plug.Model.BalancesDTO.GetDepositsBalancesRequestDTO;
import com.example.plug.Model.BalancesDTO.InfoResponseGetDepositBalancesRsDTO;
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
import java.util.concurrent.ThreadLocalRandom;


// Заглушка балансов, на входе получаем id клиента, на выходе выдаем балансы по карте JSON

@RestController
public class MainController {

    private Logger log = LoggerFactory.getLogger(MainController.class);

    ObjectMapper mapper = new ObjectMapper();

    // статистика по заглушке
    public int stat_in = 0, stat_out = 0, stat_err = 0, stat_curr = 0; //postDepositsBalances
    public int stat_in1 = 0, stat_out1 = 0, stat_err1 = 0, stat_curr1 = 0; //getDepositsBalances
    public long start_time = 0L, sum_time = 0L;
    public long start_time1 = 0L, sum_time1 = 0L;
    List<String[]> stat_tps = new ArrayList<>();
    List<String[]> stat_tps1 = new ArrayList<>();

    @PostMapping(
            value = "/infoservices/postDepositsBalances",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Object postDepositsBalances(@RequestHeader(value = "currentTbCode") Long currentTbCode, @RequestBody GetDepositsBalancesRequestDTO getDepositsBalancesRequestDTO) {
        stat_curr++;    //входящие запросы заглушки
        start_time = System.currentTimeMillis();

        try {
            String epkId = getDepositsBalancesRequestDTO.getEpkId();
            char firstDigit = epkId.charAt(0);
            BigDecimal maxBalance;
            String contractNumber = new String(epkId + "0");

            GetDepositBalancesResponseDTO getDepositBalancesResponseDTO = new  GetDepositBalancesResponseDTO();

            BalanceAccountInfoDTO balanceAccountInfoDTO = new BalanceAccountInfoDTO();

            InfoResponseGetDepositBalancesRsDTO infoResponseGetDepositBalancesRsDTO = new InfoResponseGetDepositBalancesRsDTO();

            if (firstDigit == '8' ) {
                maxBalance = new BigDecimal(2000.00);
            } else if (firstDigit == '9') {
                maxBalance = new BigDecimal(1000.00);
            } else {
                maxBalance = new BigDecimal(10000.00);;
            }

            balanceAccountInfoDTO.setAccount(contractNumber);
            balanceAccountInfoDTO.setRemainder(new BigDecimal("1000.00"));
            balanceAccountInfoDTO.setMaxSummaCharge(new BigDecimal("1000.00"));
            balanceAccountInfoDTO.setMinRemainder(new BigDecimal("00.00"));
            balanceAccountInfoDTO.setClearBalance(new BigDecimal("00.00"));
            balanceAccountInfoDTO.setMaxBalance(maxBalance);

            balanceAccountInfoDTO.setCardDeposit(true);

            getDepositBalancesResponseDTO.addAccountInfosItem(balanceAccountInfoDTO);

            infoResponseGetDepositBalancesRsDTO.setData(getDepositBalancesResponseDTO);
            infoResponseGetDepositBalancesRsDTO.setErrorCode(0);

            log.error("******* GetDepositsBalancesRequestDTO *******" + mapper.writerWithDefaultPrettyPrinter().writeValueAsString(getDepositsBalancesRequestDTO));
            log.error("******* GetDepositBalancesResponseDTO *******" + mapper.writerWithDefaultPrettyPrinter().writeValueAsString(getDepositBalancesResponseDTO));

//----------------------------------------------------------------------------

            long pacing = ThreadLocalRandom.current().nextLong(100, 600);
            long end_time = System.currentTimeMillis();
            if (end_time - start_time < pacing)   // задержска заглушки
                Thread.sleep( pacing - (end_time - start_time));
//----------------------------------------------------------------------------

            stat_out++; // исходящие ответы заглушки
            sum_time += System.currentTimeMillis() - start_time;
            return infoResponseGetDepositBalancesRsDTO;
        } catch (Exception e) {
            stat_err++;  // ошибки в заглушке
            sum_time += System.currentTimeMillis() - start_time;
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping(
            value = "/infoservices/getDepositsBalances",
            produces = "application/json"
    )
    public Object getDepositsBalances(@RequestBody GetDepositsBalancesRequestDTO getDepositsBalancesRequestDTO) {
        stat_curr1++;    //входящие запросы заглушки
        start_time1 = System.currentTimeMillis();

        try {
            String epkId = getDepositsBalancesRequestDTO.getEpkId();
            char firstDigit = epkId.charAt(0);
            String contractNumber = new String(epkId + "0");

            GetDepositBalancesResponseDTO getDepositBalancesResponseDTO = new  GetDepositBalancesResponseDTO();

            BalanceAccountInfoDTO balanceAccountInfoDTO = new BalanceAccountInfoDTO();

            InfoResponseGetDepositBalancesRsDTO infoResponseGetDepositBalancesRsDTO = new InfoResponseGetDepositBalancesRsDTO();

            balanceAccountInfoDTO.setAccount(contractNumber);
            balanceAccountInfoDTO.setRemainder(new BigDecimal("100000.00"));
            balanceAccountInfoDTO.setMaxSummaCharge(new BigDecimal("100000.00"));
            balanceAccountInfoDTO.setMinRemainder(new BigDecimal("00.00"));
            balanceAccountInfoDTO.setClearBalance(new BigDecimal("00.00"));
            balanceAccountInfoDTO.setMaxBalance(new BigDecimal("00.00"));

            balanceAccountInfoDTO.setCardDeposit(true);

            getDepositBalancesResponseDTO.addAccountInfosItem(balanceAccountInfoDTO);

            infoResponseGetDepositBalancesRsDTO.setData(getDepositBalancesResponseDTO);
            infoResponseGetDepositBalancesRsDTO.setErrorCode(0);

            log.error("******* GetDepositsBalancesRequestDTO *******" + mapper.writerWithDefaultPrettyPrinter().writeValueAsString(getDepositsBalancesRequestDTO));
            log.error("******* GetDepositBalancesResponseDTO *******" + mapper.writerWithDefaultPrettyPrinter().writeValueAsString(getDepositBalancesResponseDTO));

//----------------------------------------------------------------------------

            long pacing = ThreadLocalRandom.current().nextLong(100, 600);
            long end_time = System.currentTimeMillis();
            if (end_time - start_time1 < pacing)   // задержска заглушки
                Thread.sleep( pacing - (end_time - start_time1));
//----------------------------------------------------------------------------

            stat_out1++; // исходящие ответы заглушки
            sum_time1 += System.currentTimeMillis() - start_time1;
            return infoResponseGetDepositBalancesRsDTO;
        } catch (Exception e) {
            stat_err1++;  // ошибки в заглушке
            sum_time1 += System.currentTimeMillis() - start_time1;
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}
