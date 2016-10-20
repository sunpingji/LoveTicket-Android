package sunpj.loveticket.api;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import sunpj.loveticket.Constant;
import sunpj.loveticket.bean.Ticket;

/**
 * Created by sunpi on 2016/10/20.
 */
public class TicketApi {


    private TicketApiService service;

    public TicketApi(OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        service = retrofit.create(TicketApiService.class);
    }
    public Call<List<Ticket>> getTickets(){
        return service.getTicket();
    }

}
