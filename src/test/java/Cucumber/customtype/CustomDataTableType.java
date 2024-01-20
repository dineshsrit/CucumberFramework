package Cucumber.customtype;

import Objects.Billingdetails;
import io.cucumber.java.DataTableType;
import io.cucumber.java.Transpose;

import java.util.Map;

public class CustomDataTableType {


    @DataTableType
    public Billingdetails billingdetailsentry(Map<String, String> details)
    {
        return new Billingdetails(details.get("firstname"), details.get("lastname"),
               details.get("address1"), details.get("city"), details.get("state"),
                details.get("zip"), details.get("email"));
    }
}
