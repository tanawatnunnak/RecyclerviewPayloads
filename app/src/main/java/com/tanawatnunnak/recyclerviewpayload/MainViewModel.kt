package com.tanawatnunnak.recyclerviewpayload

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tanawatnunnak.recyclerviewpayload.model.NewsModel

class MainViewModel : ViewModel() {

    private val _newsLiveData: MutableLiveData<List<NewsModel>> = MutableLiveData()
    val newsLiveData: LiveData<List<NewsModel>> = _newsLiveData

    fun getNews() {
        _newsLiveData.value = mockNews()
    }

    fun updateFavorite(model: NewsModel, isFavorite: Boolean) {
        val news = _newsLiveData.value?.toCollection(mutableListOf()) ?: return

        _newsLiveData.value = news.map { oldModel ->
            if (oldModel.id == model.id) {
                oldModel.copy(isFavorite = isFavorite)
            } else {
                oldModel
            }
        }
    }

    private fun mockNews(): List<NewsModel> {
        return mutableListOf<NewsModel>().apply {
            add(
                NewsModel(
                    id = 1,
                    imageUrl = "https://cleantechnica.com/files/2022/11/Tesla-Model-3-Australia-road-trip-Waterhouse.jpeg",
                    title = "Can Electric Vehicles Revive the Great Aussie Road Trip? Part One",
                    description = "As petrol and diesel race each other to $2.50 a litre, electric vehicle drivers do not have to worry about the cost of their driving. We have just returned from a 3,600 kilometre great Aussie road trip which cost us about $200 in fuel … $50 on Chargefox and $…",
                )
            )


            add(
                NewsModel(
                    id = 2,
                    imageUrl = "https://cdn.i24news.tv/uploads/9a/03/b4/28/8b/b1/a6/b4/25/3d/bd/ca/cc/b5/df/a7/9a03b4288bb1a6b4253dbdcaccb5dfa7.jpg",
                    title = "Trump Twitter account reappears after Musk poll",
                    description = "The people have spoken. Trump will be reinstated.' - Click the link for more details"
                )
            )


            add(
                NewsModel(
                    id = 3,
                    imageUrl = "https://c.biztoc.com/p/7ebbb256c919afa4/og.webp",
                    title = "Elon Musk’s ‘chainsaw’ approach to Twitter won’t work, says early SpaceX investor and former Facebook executive",
                    description = "Elon Musk’s ‘chainsaw’ approach to Twitter won’t work, says early SpaceX investor and former Facebook executive Elon Musk is “well outside his depth” at Twitter and a “bullying management culture” won’t work there, says a former Facebook executive. An early"
                )
            )

            add(
                NewsModel(
                    id = 4,
                    description = "AP News in Brief at 12:04 a.m. EST",
                    title = "Historic compensation fund approved at UN climate talks",
                    imageUrl = "https://bloximages.newyork1.vip.townnews.com/richmond.com/content/tncms/custom/image/73769e9c-c54c-11ea-9ace-179ea39eeb22.jpg?resize=600%2C315"
                )
            )

            add(
                NewsModel(
                    id = 5,
                    description = "Musk says Trump's Twitter account will be reinstated, nearly 2 years after it was dropped in aftermath of Jan. 6.",
                    title = "Musk to restore Trump to Twitter after holding online poll",
                    imageUrl = "https://media.tegna-media.com/assets/CCT/images/cd48ad6c-2386-472c-8695-1996ca6ad628/cd48ad6c-2386-472c-8695-1996ca6ad628_1140x641.jpg"
                )
            )
        }
    }
}