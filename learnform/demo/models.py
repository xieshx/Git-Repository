from django.db import models


# Create your models here.
class ProductMaster(models.Model):
    product_name = models.CharField(max_length=200)


class ProductAndGroup(models.Model):
    product = models.ForeignKey('ProductMaster', on_delete=models.CASCADE)
    product_group = models.ForeignKey('ProductGroup', on_delete=models.CASCADE)


class ProductGroup(models.Model):
    product_name = models.CharField(max_length=200)
