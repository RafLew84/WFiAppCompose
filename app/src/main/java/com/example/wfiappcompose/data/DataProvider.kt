package com.example.wfiappcompose.data

import android.app.Activity
import com.example.wfiappcompose.R

object DataProvider {

    val institutes: ArrayList<Institute> = ArrayList()

    fun getInstituteData(activity: Activity){
        val instituteList = activity.resources.getStringArray(R.array.institute_titles)
        val instituteInfo = activity.resources.getStringArray(R.array.institute_info)
        val instituteImageResources = activity.resources.obtainTypedArray(R.array.institute_images)

        for (i in instituteList.indices) institutes.add(
            Institute(
                instituteList[i],
                instituteInfo[i],
                instituteImageResources.getResourceId(i, 0)
            )
        )

        instituteImageResources.recycle()
    }
}