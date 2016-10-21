package sunpj.loveticket.bean;

/**
 * Created by sunpi on 2016/10/21.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class TicketResult {

    @SerializedName("results")
    @Expose
    private List<Ticket> results = new ArrayList<Ticket>();

    /**
     *
     * @return
     * The results
     */
    public List<Ticket> getResults() {
        return results;
    }

    /**
     *
     * @param results
     * The results
     */
    public void setResults(List<Ticket> results) {
        this.results = results;
    }

}


