from django.urls import path

from demo.view import product_view

urlpatterns = [
    path('product/', product_view.main, name='product'),
]
