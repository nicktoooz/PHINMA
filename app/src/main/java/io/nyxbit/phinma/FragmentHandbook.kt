package io.nyxbit.phinma

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.nyxbit.phinma.databinding.FragmentHandbookBinding


class FragmentHandbook : Fragment() {

    private lateinit var binding : FragmentHandbookBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHandbookBinding.inflate(inflater,container,false)

        val academicPolicies = listOf(
            Pair("A. Grading System", """
        The grading system will be provided to the students by their respective teachers through the syllabus.
        If understanding of the system is not clear, it is the responsibility of the student to seek clarification
        from his/her teacher, program head, or dean.

        Grades are given out in numerical format. A student who has passed the subject will receive any of the following grades:
        1.00, 1.25, 1.50, 1.75, 2.00, 2.25, 2.50, 2.75, or 3.00. The grade of 1.00 is the highest possible grade
        that a student may get. A student who has failed the subject will receive a grade of 5.00.

        A student may also get a grade other than those specified earlier. These grades may be given for various reasons such as,
        but not limited to: incompleteness of submitted requirements, withdrawal from a subject - with permission,
        withdrawal from a subject - without permission, failure due to absences, no examination because the student
        was not able to obtain an exam permit.
    """.trimIndent()),

            Pair("B. Release of Grades", """
        Final grades will be released by the Office of the Registrar. Other term exams will be released by the faculty.
    """.trimIndent()),

            Pair("C. Incomplete Grade", """
        A student who gets an incomplete grade has two consecutive terms to complete it. The Dean/Director must have
        approved the granting of the incomplete grade. Failure to get a passing grade for an incomplete grade after
        two terms have elapsed means that the student will get a failing mark in the subject concerned. The corresponding
        completion fee shall be applied.
    """.trimIndent()),

            Pair("D. Academic Probation", """
        A student who incurs failing grades in three (3) subjects of his academic load in a semester will be accepted on probation
        the following semester, and the student will only be allowed to carry a maximum load of 18 units. Should the student fail
        in two (2) subjects during the probationary period, a maximum load of 12 units shall be enforced. The student may assume
        a regular load only when the mentioned 12 units have been passed.
    """.trimIndent()),

            Pair("E. Class Attendance", """
        1. Every student is required to attend his classes regularly and punctually. Absence or persistent tardiness for more than
           20% of the total number of class meetings (one hour for each meeting) during the entire course in any particular subject
           shall be sufficient reason for disqualifying a student from taking final examinations or for dropping the student without credit.

           The same shall apply if a student has incurred:
           - More than 3 absences in a 1-unit subject
           - More than 5 absences in a 2-unit subject
           - More than 8 absences in a 3-unit subject
           - More than 11 absences in a 4-unit subject
           - More than 14 absences in a 5-unit subject
           - More than 17 absences in a 6-unit subject

        2. A student who is late for class for at least 10 minutes will be marked as absent.

        3. A student will incur an absence for every 3 times that he is tardy.
    """.trimIndent())
        )

// Print each section
        academicPolicies.forEach { (section, description) ->
            println("$section:\n$description\n")
        }

        val adapter = HandbookPagerAdapter(academicPolicies)

        binding.pagerHandboook.adapter = adapter

        return binding.root
    }

}