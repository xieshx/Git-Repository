from django import forms
from django.core.exceptions import ValidationError


class ProductForm(forms.Form):
    product_name = forms.CharField(label="产品名")
    product_group = forms.CharField(label="产品组")

    def clean(self):
        product_name = self.cleaned_data.get('product_name')
        product_group = self.cleaned_data.get('product_group')
        if product_name and product_group:
            return self.cleaned_data
        raise ValidationError('数据为空')
