package com.example.darksher.fancytracker.navigation


import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.android.SupportFragmentNavigator

object NavigatorFactory {

    fun create(fm: FragmentManager, activity: AppCompatActivity, container: Int): Navigator {
        return object : SupportFragmentNavigator(fm, container) {
            /**
             * Creates Fragment matching `screenKey`.
             *
             * @param screenKey screen key
             * @param data      initialization data
             * @return instantiated fragment for the passed screen key
             */
            override fun createFragment(screenKey: String?, data: Any?): Fragment? = FragmentsFactory.create(screenKey, data)


            /**
             * Called when we try to back from the root.
             */
            override fun exit() {
                activity.finish()
            }

            /**
             * Shows system message.
             *
             * @param message message to show
             */
            override fun showSystemMessage(message: String?) {
                Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
            }

        }
    }
}