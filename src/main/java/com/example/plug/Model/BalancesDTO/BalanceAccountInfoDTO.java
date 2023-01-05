package com.example.plug.Model.BalancesDTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.Objects;

public class BalanceAccountInfoDTO {
    @JsonProperty("account")
    private String account;

    @JsonProperty("remainder")
    private BigDecimal remainder;

    @JsonProperty("maxSummaCharge")
    private BigDecimal maxSummaCharge;

    @JsonProperty("minRemainder")
    private BigDecimal minRemainder;

    @JsonProperty("clearBalance")
    private BigDecimal clearBalance;

    @JsonProperty("maxBalance")
    private BigDecimal maxBalance;

    @JsonProperty("cardDeposit")
    private Boolean cardDeposit;

    public BalanceAccountInfoDTO account(String account) {
        this.account = account;
        return this;
    }

    /**
     * Get account
     * @return account
     */
    //@ApiModelProperty(value = "")

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public BalanceAccountInfoDTO remainder(BigDecimal remainder){
        this.remainder = remainder;
        return this;
    }

    /**
     * Get remainder
     * @return remainder
     */
    //@ApiModelProperty(value = "")

    @Valid

    public BigDecimal getRemainder() {
        return remainder;
    }

    public void setRemainder(BigDecimal remainder) {
        this.remainder = remainder;
    }

    public BalanceAccountInfoDTO maxSummaCharge(BigDecimal maxSummaCharge){
        this.maxSummaCharge = maxSummaCharge;
        return this;
    }

    /**
     * Get maxSummaCharge
     * @return maxSummaCharge
     */
    //@ApiModelProperty(value = "")

    @Valid

    public BigDecimal getMaxSummaCharge() {
        return maxSummaCharge;
    }

    public void setMaxSummaCharge(BigDecimal maxSummaCharge) {
        this.maxSummaCharge = maxSummaCharge;
    }

    public BalanceAccountInfoDTO minRemainder(BigDecimal minRemainder){
        this.minRemainder = minRemainder;
        return this;
    }

    /**
     * Get minRemainder
     * @return minRemainder
     */
    //@ApiModelProperty(value = "")

    @Valid

    public BigDecimal getMinRemainder() {
        return minRemainder;
    }

    public void setMinRemainder(BigDecimal minRemainder) {
        this.minRemainder = minRemainder;
    }

    public BalanceAccountInfoDTO clearBalance(BigDecimal clearBalance){
        this.clearBalance = clearBalance;
        return this;
    }

    /**
     * Get clearBalance
     * @return clearBalance
     */
    //@ApiModelProperty(value = "")

    @Valid

    public BigDecimal getClearBalance() {
        return clearBalance;
    }

    public void setClearBalance(BigDecimal clearBalance) {
        this.clearBalance = clearBalance;
    }

    public BalanceAccountInfoDTO maxBalance(BigDecimal maxBalance){
        this.maxBalance = maxBalance;
        return this;
    }

    /**
     * Get maxBalance
     * @return maxBalance
     */
    //@ApiModelProperty(value = "")

    @Valid

    public BigDecimal getMaxBalance() {
        return maxBalance;
    }

    public void setMaxBalance(BigDecimal maxBalance) {
        this.maxBalance = maxBalance;
    }

    public BalanceAccountInfoDTO cardDeposit(boolean cardDeposit){
        this.cardDeposit = cardDeposit;
        return this;
    }

    /**
     * Get cardDeposit
     * @return cardDeposit
     */
    //@ApiModelProperty(value = "")

    public Boolean getCardDeposit() {
        return cardDeposit;
    }

    public void setCardDeposit(Boolean cardDeposit) {
        this.cardDeposit = cardDeposit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BalanceAccountInfoDTO balanceAccountInfoDTO = (BalanceAccountInfoDTO) o;
        return Objects.equals(this.account, balanceAccountInfoDTO.account) &&
                Objects.equals(this.remainder, balanceAccountInfoDTO.remainder) &&
                Objects.equals(this.maxSummaCharge, balanceAccountInfoDTO.maxSummaCharge) &&
                Objects.equals(this.minRemainder, balanceAccountInfoDTO.minRemainder) &&
                Objects.equals(this.clearBalance, balanceAccountInfoDTO.clearBalance) &&
                Objects.equals(this.maxBalance, balanceAccountInfoDTO.maxBalance) &&
                Objects.equals(this.cardDeposit, balanceAccountInfoDTO.cardDeposit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(account, remainder, maxSummaCharge, minRemainder, clearBalance, maxBalance, cardDeposit);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class BalanceAccountInfoDTO {\n");

        sb.append("   account: ").append(toIndentedString(account)).append("\n");
        sb.append("   remainder:  ").append(toIndentedString(remainder)).append("\n");
        sb.append("   maxSummaCharge:  ").append(toIndentedString(maxSummaCharge)).append("\n");
        sb.append("   minRemainder:  ").append(toIndentedString(minRemainder)).append("\n");
        sb.append("   clearBalance:  ").append(toIndentedString(clearBalance)).append("\n");
        sb.append("   maxBalance:  ").append(toIndentedString(maxBalance)).append("\n");
        sb.append("   cardDeposit:  ").append(toIndentedString(cardDeposit)).append("\n");
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
