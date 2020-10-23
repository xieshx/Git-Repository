from django.urls import path
from versionid.views.versionid import version_register

urlpatterns = [
    path('register/', version_register.main, name='version_register'),
]
