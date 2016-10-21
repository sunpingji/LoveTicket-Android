package sunpj.loveticket.api;

import retrofit2.Call;
import retrofit2.http.GET;
import sunpj.loveticket.bean.TicketResult;

/**
 * Created by sunpi on 2016/10/20.
 */

public interface TicketApiService {

    @GET("classes/Ticket")
    Call<TicketResult> getTicket();
}
