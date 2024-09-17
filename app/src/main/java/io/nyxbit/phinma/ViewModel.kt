package io.nyxbit.phinma

import androidx.lifecycle.ViewModel

class ViewModel : ViewModel(){
    var initiator : String = ""
    var school : School = School.NONE
    var fullName : String = ""
    var course : String = ""
    var year : String = ""
    var address: String = ""
    var mobileNumber : String = ""
    var date : String = ""

    fun clear(){
        school = School.NONE
        fullName = ""
        course = ""
        year = ""
        address = ""
        mobileNumber = ""
        date = ""
    }
}