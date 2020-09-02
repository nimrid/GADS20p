package com.example.gads20p

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gads20p.adapter.LearningHrAdapter
import com.example.gads20p.model.LearningHours
import com.example.gads20p.model.LearningHoursItem
import com.example.gads20p.request.ApiCall
import kotlinx.android.synthetic.main.fragment_learner.*
import retrofit2.Call
import retrofit2.Response

class LearnerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_learner, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        learner_fragment.layoutManager = LinearLayoutManager(activity)

        val hours =  ArrayList<LearningHoursItem?>()

        val response = ApiCall.invoke().getLearningHours()

        response.enqueue(object : retrofit2.Callback<LearningHours>{
            override fun onFailure(call: Call<LearningHours>, t: Throwable) {

            }

            override fun onResponse(call: Call<LearningHours>, response: Response<LearningHours>) {
                for (hrs in response.body()!!){
                    hours.add(hrs)
                }
                learner_fragment.adapter = LearningHrAdapter(hours, context!!)
            }


        })




    }


}
