
import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    /*
    industry_name为以下三种之一
        law,teafinnace,medical
    错误码：
        241000//行业从未激活
        241001//行业已到期
        241002//行业不存在

    getIndustryInfo获取行业状态,返回rc
    get_activate_industry激活行业状态,返回rc和dead_line两个字段
    */
    @GET("get_industry_activate_info")
    fun getIndustryInfo(@Query("devid") devid:String,@Query("industry_name") industryName: String) : Observable<ResponseBody>?

    @GET("get_activate_industry")
    fun getActivateIndustry(@Query("devid") devid:String,@Query("industry_name") industryName: String) : Call<Any>?

}