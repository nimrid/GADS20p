package com.example.gads20p


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gads20p.adapter.SkillAdapter
import com.example.gads20p.model.SkillIQ
import com.example.gads20p.model.SkillIQItem
import com.example.gads20p.request.ApiCall
import kotlinx.android.synthetic.main.fragment_skill.*
import retrofit2.Call
import retrofit2.Response

class SkillFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_skill, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val skill = ArrayList<SkillIQItem?>()
        val response = ApiCall.invoke().getSkillIQ()
        skill_recycler.layoutManager = LinearLayoutManager(activity)

        response.enqueue(object : retrofit2.Callback<SkillIQ?>{
            override fun onFailure(call: Call<SkillIQ?>, t: Throwable) {

            }

            override fun onResponse(call: Call<SkillIQ?>, response: Response<SkillIQ?>) {
                for (score in response.body()!!){
                    skill.add(score)
                }
                skill_recycler.adapter = SkillAdapter(skill, context!!)
            }


        })
    }


}
