package Cucumber.files;

import Cucumber.objects.Customer;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.Transpose;
import io.cucumber.java.en.Given;


import java.util.List;
import java.util.Map;


public class DatatableStepdef {

    @DataTableType
    public Customer customer(List<String> entry)
    {
        return new Customer(entry.get(0), entry.get(1));
    }

    @Given("my credentials")
    public void my_credentials(DataTable table) {
      List<List<String>> customer= table.asLists();

         System.out.println("Username:" + customer.get(0).get(0));
         System.out.println("Password:" + customer.get(0).get(1));
       /* System.out.println("Username:" + customer.get(1).get(0));
        System.out.println("Password:" + customer.get(1).get(1));*/
        /*System.out.println("Username:" + customer.get(0).get(2));
        System.out.println("Password:" + customer.get(0).get(3));*/

    }
}
