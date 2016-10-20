package sunpj.loveticket.api;

import android.database.Observable;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import sunpj.loveticket.bean.Ticket;

/**
 * Created by sunpi on 2016/10/20.
 */

public interface TicketApiService {

    @GET("classes/Ticket")
    Call<List<Ticket>> getTicket();
}
