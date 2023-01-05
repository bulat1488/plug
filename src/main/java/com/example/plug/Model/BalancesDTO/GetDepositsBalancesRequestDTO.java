package com.example.plug.Model.BalancesDTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GetDepositsBalancesRequestDTO {
    @JsonProperty("epkId")
    private String epkId;

    @JsonProperty("accounts")
    @Valid
    private List<String> accounts = null;

    @JsonProperty("includeClosed")
    private Boolean includeClosed;

    @JsonProperty("notIncludeCardAccount")
    private Boolean notIncludeCardAccount;

    public GetDepositsBalancesRequestDTO epkId(String epkId) {
        this.epkId = epkId;
        return this;
    }

    /**
     * Get epkId
     * @return epkId
     */
    //@ApiModelProperty(value = "")

    public String getEpkId() {
        return epkId;
    }

    public void setEpkId(String epkId) {
        this.epkId = epkId;
    }

    public GetDepositsBalancesRequestDTO accounts(List<String> accounts){
        this.accounts = accounts;
        return this;
    }

    public GetDepositsBalancesRequestDTO addAccountsItem(String accountsItem){
        if (this.accounts == null) {
            this.accounts = new ArrayList<>();
        }
        this.accounts.add(accountsItem);
        return this;
    }

    /**
     * Get accounts
     * @return accounts
     */
    //@ApiModelProperty(value = "")

    public List<String> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<String> accounts) {
        this.accounts = accounts;
    }

    public GetDepositsBalancesRequestDTO includClosed(boolean includeClosed) {
        this.includeClosed = includeClosed;
        return this;
    }

    /**
     * Get includClosed
     * @return includClosed
     */
    //@ApiModelProperty(value = "")

    public Boolean getIncludeClosed() {
        return includeClosed;
    }

    public void setIncludeClosed(boolean includeClosed) {
        this.includeClosed = includeClosed;
    }

    public GetDepositsBalancesRequestDTO notIncludeCardAccount(boolean notIncludeCardAccount) {
        this.notIncludeCardAccount = notIncludeCardAccount;
        return this;
    }

    /**
     * Get notIncludeCardAccount
     * @return notIncludeCardAccount
     */
    //@ApiModelProperty(value = "")

    public Boolean getNotIncludeCardAccount(){
        return notIncludeCardAccount;
    }

    public void setNotIncludeCardAccount(boolean notIncludeCardAccount) {
        this.notIncludeCardAccount =notIncludeCardAccount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if ( o == null || getClass() != o.getClass()) {
            return false;
        }
        GetDepositsBalancesRequestDTO getDepositsBalancesRequestDTO = (GetDepositsBalancesRequestDTO) o;
        return Objects.equals(this.epkId, getDepositsBalancesRequestDTO.epkId) &&
                Objects.equals(this.accounts, getDepositsBalancesRequestDTO.epkId) &&
                Objects.equals(this.includeClosed, getDepositsBalancesRequestDTO.epkId) &&
                Objects.equals(this.notIncludeCardAccount, getDepositsBalancesRequestDTO.epkId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(epkId, accounts, includeClosed, notIncludeCardAccount);
        }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DepositsBalancesRequestDTO {\n");

        sb.append("   epkId: ").append(toIndentedString(epkId)).append("\n");
        sb.append("   accounts:  ").append(toIndentedString(accounts)).append("\n");
        sb.append("   includeClosed:  ").append(toIndentedString(includeClosed)).append("\n");
        sb.append("   notIncludeCardAccount:  ").append(toIndentedString(epkId)).append("\n");
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
