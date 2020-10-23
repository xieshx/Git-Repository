import os

from django.http import HttpResponse
from django.shortcuts import render

base_params = {
    'env': os.environ.get('ENV')
}


def enter(request):
    # request.session.clear()
    # request.session.flush()
    return render(request, 'versionid/version_id_manage.html')
    # return render(request, 'base.html')
    # return HttpResponse('hello world')
