package com.test.kotlindemo

import ApiService
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.ObservableOnSubscribe
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        RxjavaTest()
        RetrofitTest()
        Glide.with(this).load("www.baidu.com").into(ImageView(this))
        ObserverTest()
    }

    private fun ObserverTest() {
        var observable = java.util.Observable()
    }

    private fun RetrofitTest() {
        var callAdapter = null
        var converter = null
        var retrofit = Retrofit.Builder()
                .baseUrl("www.baidu.com")
                .addCallAdapterFactory(callAdapter)
                .addConverterFactory(converter)
                .build()

        var apiService = retrofit.create(ApiService::class.java)
        //直接返回callback对象
        apiService.getActivateIndustry("deviceId", "industryName")?.enqueue(object : Callback<Any> {
            override fun onFailure(call: Call<Any>, t: Throwable) {
            }

            override fun onResponse(call: Call<Any>, response: Response<Any>) {
            }
        })
        //结合Rxjava返回观察者对象
        apiService.getIndustryInfo("deviceId", "industryName")
                ?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe(object : Consumer<ResponseBody> {
                    override fun accept(t: ResponseBody?) {

                    }
                })
    }

    private fun RxjavaTest() {
         Thread()
        Observable.create(object : ObservableOnSubscribe<Integer> {
            override fun subscribe(e: ObservableEmitter<Integer>) {
                var num = 88
                e.onNext(num)
            }
        })
                .map(object : Function<Integer, String> {
                    override fun apply(t: Integer): String {
                        return "receive a number:" + t.toInt()
                    }
                })
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(Schedulers.io())
                .subscribe {
                    object : Observer<String> {
                        override fun onComplete() {
                        }

                        override fun onSubscribe(d: Disposable) {
                        }

                        override fun onNext(t: String) {
                        }

                        override fun onError(e: Throwable) {
                        }
                    }
                }
    }

}

private fun <T> Observable<T>?.subscribe(t: T) {

}

private fun <T> ObservableEmitter<T>.onNext(num: Int) {

}
