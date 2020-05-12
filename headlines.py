from selenium.webdriver import Chrome
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.chrome.options import Options


options = Options()
options.add_argument('--headless')
browser = Chrome(options=options)

browser.get('https://inshorts.com/en/read')
headlines = browser.find_elements_by_class_name('news-card-title')


news = []
links = []

for head in headlines:
    temp = head.text
    temp = temp.split('\n')
    news.append(temp[0])
    ref = head.find_element_by_tag_name('a').get_attribute('href')
    links.append(ref)
    
print('Headlines:\n------------------------------------\n')
for i in range(len(news)):
    print(str(i+1) + ') ' + news[i] + '\n')
    print('Link: ' + links[i] + '\n-------------------------------------------------------\n')
