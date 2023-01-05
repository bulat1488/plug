package com.example.plug.Model.BalancesDTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;
import java.util.Objects;

public class InfoResponseGetDepositBalancesRsDTO {
    @JsonProperty("data")
    private GetDepositBalancesResponseDTO data;

    @JsonProperty("errorCode")
    private Integer errorCode;

    @JsonProperty("errorMessage")
    private String errorMessage;

    @JsonProperty("additionalInfo")
    private String additionalInfo;

    public InfoResponseGetDepositBalancesRsDTO data(GetDepositBalancesResponseDTO data) {
        this.data =data;
        return this;
    }

    /**
     * Get data
     * @return data
     */
    //@ApiModelProperty(value = "")

    @Valid

    public GetDepositBalancesResponseDTO getData() {
        return data;
    }

    public void setData(GetDepositBalancesResponseDTO data) {
        this.data = data;
    }

    public InfoResponseGetDepositBalancesRsDTO errorCode(Integer errorCode){
        this.errorCode = errorCode;
        return this;
    }

    /**
     * Get errorCode
     * @return errorCode
     */
    //@ApiModelProperty(value = "")


    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public InfoResponseGetDepositBalancesRsDTO errorMessage(String errorMessage){
        this.errorMessage = errorMessage;
        return this;
    }

    /**
     * Get errorMessage
     * @return errorMessage
     */
    //@ApiModelProperty(value = "")


    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public InfoResponseGetDepositBalancesRsDTO additionalInfo(String additionalInfo){
        this.additionalInfo = additionalInfo;
        return this;
    }

    /**
     * Get additionalInfo
     * @return additionalInfo
     */
    //@ApiModelProperty(value = "")


    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        InfoResponseGetDepositBalancesRsDTO infoResponseGetDepositBalancesRsDTO = (InfoResponseGetDepositBalancesRsDTO) o;
        return Objects.equals(this.data, infoResponseGetDepositBalancesRsDTO.data) &&
                Objects.equals(this.errorCode, infoResponseGetDepositBalancesRsDTO.errorCode) &&
                Objects.equals(this.errorMessage, infoResponseGetDepositBalancesRsDTO.errorMessage) &&
                Objects.equals(this.additionalInfo, infoResponseGetDepositBalancesRsDTO.additionalInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, errorCode, errorMessage, additionalInfo);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class InfoResponseGetDepositBalancesRsDTO {\n");

        sb.append("   data: ").append(toIndentedString(data)).append("\n");
        sb.append("   errorCode:  ").append(toIndentedString(errorCode)).append("\n");
        sb.append("   errorMessage:  ").append(toIndentedString(errorMessage)).append("\n");
        sb.append("   additionalInfo:  ").append(toIndentedString(additionalInfo)).append("\n");
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
