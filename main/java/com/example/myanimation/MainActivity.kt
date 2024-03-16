package com.example.myanimation

import android.animation.Animator
import android.animation.AnimatorInflater
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    val MENU_ALPHA_ID = 1
    val MENU_SCALE_ID = 2
    val MENU_TRANSLATE_ID = 3
    val MENU_ROTATE_ID = 4
    val MENU_COMBO_ID = 5
    val MENU_BACKGROUND_ID = 6
    val MENU_COMBO_BTN_ID = 7
    var tv: TextView? = null
    var btn: Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)

        tv = findViewById(R.id.tv)
        registerForContextMenu(tv)
        btn = findViewById(R.id.btn)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        val id = v?.getId()
        when (id) {
            R.id.tv -> {
                menu?.add(0, MENU_ALPHA_ID, 0, "alpha")
                menu?.add(0, MENU_SCALE_ID, 0, "scale")
                menu?.add(0, MENU_TRANSLATE_ID, 0, "translate")
                menu?.add(0, MENU_ROTATE_ID, 0, "rotate")
                menu?.add(0, MENU_COMBO_ID, 0, "combo")
                menu?.add(0, MENU_BACKGROUND_ID, 0, "background")
                menu?.add(0, MENU_COMBO_BTN_ID, 0, "Анимировать кнопку")
            }
        }
        super.onCreateContextMenu(menu, v, menuInfo)
    }


    override fun onContextItemSelected(item: MenuItem): Boolean {
        var anim: Animation? = null
        var animator: Animator? = null
        when (item.itemId) {
            MENU_ALPHA_ID -> {
                anim = AnimationUtils.loadAnimation(this, R.anim.myalpha)
                tv?.startAnimation(anim)
            }

            MENU_SCALE_ID -> {
                anim = AnimationUtils.loadAnimation(this, R.anim.myscale)
                tv?.startAnimation(anim)
            }

            MENU_TRANSLATE_ID -> {
                anim = AnimationUtils.loadAnimation(this, R.anim.mytrans)
                tv?.startAnimation(anim)
            }

            MENU_ROTATE_ID -> {
                anim = AnimationUtils.loadAnimation(this, R.anim.myrotate)
                tv?.startAnimation(anim)
            }

            MENU_COMBO_ID -> {
                anim = AnimationUtils.loadAnimation(this, R.anim.mycombo)
                tv?.startAnimation(anim)
            }

            MENU_BACKGROUND_ID -> {
                animator = AnimatorInflater.loadAnimator(this, R.animator.myobjectanim)
                        animator?.setTarget(tv)
                        animator?.start()
            }

            MENU_COMBO_BTN_ID -> {
                anim = AnimationUtils.loadAnimation(this, R.anim.combobtn)
                btn?.startAnimation(anim)
                animator = AnimatorInflater.loadAnimator(this, R.animator.colorbtn)
                animator?.setTarget(btn)
                animator?.start()
            }
        }
        return super.onContextItemSelected(item)
    }


}