package sunpj.loveticket;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by sunpi on 2016/10/20.
 */
public class AppProfile {
    private static AppProfile ourInstance = new AppProfile();

    public static AppProfile getInstance() {
        return ourInstance;
    }

    private OkHttpClient okHttpClient;

    private AppProfile() {
        init();
    }

    private void init() {
        okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request().newBuilder()
                                .addHeader("X-LC-Id", Constant.APP_ID)
                                .addHeader("X-LC-Key", Constant.APP_KEY)
                                .build();
                        return chain.proceed(request);
                    }
                }).build();
    }

    public OkHttpClient getOkHttpClient() {
        return okHttpClient;
    }
}
