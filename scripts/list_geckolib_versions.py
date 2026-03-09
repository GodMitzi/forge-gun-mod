import re, urllib.request

url = 'https://repo1.maven.org/maven2/software/bernie/'
html = urllib.request.urlopen(url).read().decode('utf-8', errors='ignore')
packages = set(re.findall(r'href="([^"]+)/"', html))
for p in sorted(packages):
    if p.startswith('gecko') or p.startswith('geckolib'):
        print(p)
