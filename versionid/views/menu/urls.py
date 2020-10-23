from django.urls import path
from versionid.views.menu import views

urlpatterns = [
    # 进入ID管理界面
    path('enter/', views.enter, name='enter'),
]
