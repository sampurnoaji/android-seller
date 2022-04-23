package id.io.android.seller.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import dagger.hilt.android.lifecycle.HiltViewModel
import id.io.android.seller.domain.model.user.User
import id.io.android.seller.domain.usecase.user.UserUseCases
import id.io.android.seller.util.LoadState
import id.io.android.seller.util.LoadStateUtil
import id.io.android.seller.util.NoParams
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val userUseCases: UserUseCases) : ViewModel() {

    val isLoggedIn: Boolean get() = userUseCases.getIsLoggedInUseCase()

    val user: LiveData<LoadState<User>> = liveData {
        emit(LoadState.Loading)
        emit(LoadStateUtil.map(userUseCases.getUserUseCase(NoParams)))
    }

    fun logout() {
        userUseCases.setLoggedInUseCase(false)
    }
}