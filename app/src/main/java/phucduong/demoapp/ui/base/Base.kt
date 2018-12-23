package phucduong.demoapp.ui.base

interface Base {
    interface View {

        fun showProgress()

        fun hideProgress()
    }

    interface Presenter<V : View, I : Interactor> {

        fun onAttach(v : V?)
        fun onDetach()
        fun getView() : V?
    }

    interface Interactor {
    }
}