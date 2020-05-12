from selenium.webdriver import Chrome
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.chrome.options import Options
import pandas as pd
import sys


if len(sys.argv) < 2:
    print('Usage: python corona.py CountryName')

else:
    options = Options()
    options.add_argument('--headless')

    print('Retreiving data.....')
    browser = Chrome(options = options)
    action = ActionChains(browser)
    browser.get('https://news.google.com/covid19/map?hl=en-IN&gl=IN&ceid=IN:en')

    q = browser.find_element_by_class_name('JMntpc')
    action.move_to_element(q).perform()

    table = browser.find_element_by_class_name('ppcUXd')

    rows = table.find_elements_by_tag_name('tr')
    data = []
    for row in rows:
        r = row.text
        s1 = r.split('\n')
        s2 = s1[1].split(' ')
        s1 = s1[0]
        s2.insert(0, s1)
        data.append(s2)


    df = pd.DataFrame(data, columns=['Countries', 'Confirmed', 'Cases per million', 'Recovered', 'Deaths'])
    df.index = df['Countries']
    df = df.drop(['Countries'], axis=1)
    df.to_csv('coronavirus_data.csv')
    browser.close()
    
    
    for i in range (1, len(sys.argv)):
        p = sys.argv[i]
        print('\n' + p)
        print('Confirmed: ' + df.loc[p]['Confirmed'])
        print('Cases per million: ' + df.loc[p]['Cases per million'])
        print('Recovered: ' + df.loc[p]['Recovered'])
        print('Deaths: ' + df.loc[p]['Deaths'])
