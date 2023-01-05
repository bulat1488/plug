package com.example.plug.Model.BalancesDTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class GetDepositBalancesResponseDTO {
    @JsonProperty("accountInfos")
    @Valid
    private List<BalanceAccountInfoDTO> accountInfo = null;

    public GetDepositBalancesResponseDTO accountInfo(List<BalanceAccountInfoDTO> accountInfo) {
        this.accountInfo = accountInfo;
        return this;
    }

    public GetDepositBalancesResponseDTO addAccountInfosItem(BalanceAccountInfoDTO accountInfoItem) {
        if (this.accountInfo == null) {
            this.accountInfo = new ArrayList<>();
        }
        this.accountInfo.add(accountInfoItem);
        return this;
    }

    /**
     * Get accountInfo
     * @return accountInfo
     */
    //@ApiModelProperty(value = "")

    @Valid

    public List<BalanceAccountInfoDTO> getAccountInfo() {
        return accountInfo;
    }

    public void setAccountInfo(List<BalanceAccountInfoDTO> accountInfo) {
        this.accountInfo = accountInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GetDepositBalancesResponseDTO getDepositBalancesResponseDTO = (GetDepositBalancesResponseDTO) o;
        return Objects.equals(this.accountInfo, getDepositBalancesResponseDTO.accountInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountInfo);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GetDepositBalancesResponseDTO {\n");

        sb.append("   accountInfo: ").append(toIndentedString(accountInfo)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */

    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n   ");
    }
}
