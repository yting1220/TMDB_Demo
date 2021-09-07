package com.example.tmdb_demo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import com.example.navigationdrawer.PersonalFragment
import com.example.navigationdrawer.StarFragment
import com.example.tmdb_demo.databinding.ActivityTmdbBinding

class TmdbActivity : AppCompatActivity() {

    companion object {
        const val TAG = "Tmdb"
    }

    private lateinit var binding: ActivityTmdbBinding
    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTmdbBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d(TAG, intent.getStringExtra("From").toString())

        // Bottom Navigation
        with(binding) {
            tmdbNavigation.setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.navigation_movie -> {
                        Log.d(TAG, "MOVIE")
                        val manager = supportFragmentManager
                        val transaction = manager.beginTransaction()
                        val movieFragment = MovieFragment()
                        transaction.replace(R.id.fragmentHolder, movieFragment).commit()
                        transaction.addToBackStack(null)
                        return@setOnItemSelectedListener true
                    }
                    R.id.navigation_drama -> {
                        Log.d(TAG, "Drama")
                        val manager = supportFragmentManager
                        val transaction = manager.beginTransaction()
                        val dramaFragment = DramaFragment()
                        transaction.replace(R.id.fragmentHolder, dramaFragment).commit()
                        transaction.addToBackStack(null)
                        return@setOnItemSelectedListener true
                    }
                }
                false
            }
        }

//        ActionBarDrawerToggle用於傳入要綁訂的 DrawerLayout 和 ToolBar，以及傳入開啟和關閉的 string 資源檔
//        呼叫 toggle.syncState() 讓 toggle 和 drawer 的狀態保持一致
//        setSupportActionBar 加上我們自訂的 toolbar
//        設定 NavigationView 按下項目時的事件
        toggle = ActionBarDrawerToggle(this, binding.drawerLayout, R.string.open, R.string.close)

        //drawer.addDrawerListener 方法是去監聽 drawer views 的事件
        binding.drawerLayout.addDrawerListener(toggle)
        //呼叫 toggle.syncState() 讓 toggle 和 drawer 的狀態保持一致（漢堡和側邊欄）
        toggle.syncState()

        //顯示漢堡
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.navView.setNavigationItemSelectedListener {
            val manager = supportFragmentManager
            val transaction = manager.beginTransaction()
            when(it.itemId) {
                R.id.menu_home -> {
                    Toast.makeText(
                        applicationContext,
                        "click home", Toast.LENGTH_SHORT
                    ).show()
                    val fragment = MovieFragment()
                    transaction.replace(R.id.fragmentHolder, fragment).commit()
                }
                R.id.menu_star -> {
                    Toast.makeText(
                        applicationContext,
                        "click star", Toast.LENGTH_SHORT
                    ).show()
                    val fragment = StarFragment()
                    transaction.replace(R.id.fragmentHolder, fragment).commit()
                }
                R.id.personal_data -> {
                    Toast.makeText(
                        applicationContext,
                        "click personal", Toast.LENGTH_SHORT
                    ).show()
                    val fragment = PersonalFragment()
                    transaction.replace(R.id.fragmentHolder, fragment).commit()
                }
                R.id.logout -> {
                    Toast.makeText(
                        applicationContext,
                        "click logout", Toast.LENGTH_SHORT
                    ).show()
                    startActivity(Intent(this, LoginActivity::class.java).putExtra("From", "TmdbActivity"))
                }
            }
            binding.drawerLayout.closeDrawers()
            true
        }
    }

    // Button on ActionBar
//    override fun onOptionsItemSelected(item: MenuItem): Boolean =
//        when (item.itemId) {
//            android.R.id.home -> {
//                onBackPressed()
//                true
//            }
//            else -> super.onOptionsItemSelected(item)
//        }

    // 側邊欄收回
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}