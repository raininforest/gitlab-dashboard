package com.github.raininforest.login.di

import com.github.raininforest.core.di.CoreDependencies
import com.github.raininforest.login.ui.LoginViewModel
import dagger.Component

@LoginScope
@Component(dependencies = [CoreDependencies::class])
interface LoginComponent {

    val loginViewModel: LoginViewModel

    @Component.Builder
    interface Builder {
        fun deps(deps: CoreDependencies): Builder

        fun build(): LoginComponent
    }
}
