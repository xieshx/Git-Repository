from django.http import HttpResponse
from django.shortcuts import render

from demo.form.product_view import ProductForm


def main(request):
    if request.method == 'GET':
        product = ProductForm(use_required_attribute=False)
        param = {
            'product': product
        }
        return render(request, 'product_view.html', param)
    else:
        product = ProductForm(request.POST)
        if product.is_valid():
            product_name = product.cleaned_data.get('product_name')
            return HttpResponse('hello')
        else:
            errors = product.errors.get('__all__')
            param = {
                'errors': errors
            }
            return render(request, 'product_view.html', param)
